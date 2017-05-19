@RunWith(SpringRunner.class)
@SpringBootTest(classes = { YourConfigClass.class })
@ActiveProfiles("test")
public abstract class AbstractTest {
    // Nothing needed here, or add some code if you'd like...
}