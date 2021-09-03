package watchy_api.services;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;

/**
 *
 * @author edward
 */
 @MicronautTest
public class IpApiClientTest {

    @Inject
    IpApiClient client;

     public IpApiClientTest() {
    }

    @Test
    public void testLocal() {
        var result = client.get("209.6.114.124");
        assertThat(result.body().getTimezone()).isEqualTo("America/New_York");
        var rateLimit = result.getHeaders().getInt("X-Rl");
        assertThat(rateLimit).isNotNull();
    }

}