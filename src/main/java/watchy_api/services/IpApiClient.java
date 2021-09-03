package watchy_api.services;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.client.annotation.Client;

/**
 * http://ip-api.com/json/{query}?fields=49600
 * @author edward
 */
 @Client("http://ip-api.com/json")
public interface IpApiClient {
    @Get("/{ip}?fields=49600")
    public HttpResponse<IpApiResult> get(@PathVariable String ip);

}
