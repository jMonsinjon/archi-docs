@RunWith(SpringRunner.class)
@SpringBootTest(classes = { YourMainConfig.class })
public abstract class AbstractTest {
    // Nothing needed here, or add some code if you'd like...
}

public class SynonymSettingsIT extends AbstractTest {
    // Your tests
}