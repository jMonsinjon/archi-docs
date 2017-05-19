import com.cdiscount.archi.base.aspect.FeatureFlipping;
import com.cdiscount.archi.base.info.FeatureFlippingInfo;
import com.cdiscount.archi.base.util.FeatureFlippingThreadLocal;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class MyController {

    @GetMapping("/action")
    @FeatureFlipping(ids= {"12", "32"})
    public String action() {
        FeatureFlippingInfo featureFlippingInfo = FeatureFlippingThreadLocal.get();
        String siteId = featureFlippingInfo.getSiteId();
        Map<String, Boolean> features = featureFlippingInfo.getFeatures();

        return "Feature 12 is " + features.get("12") ? "active" : "inactive";
    }
}