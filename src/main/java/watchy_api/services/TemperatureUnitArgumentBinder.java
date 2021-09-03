package watchy_api.services;

import io.micronaut.core.convert.ArgumentConversionContext;
import io.micronaut.core.type.Argument;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.client.bind.ClientRequestUriContext;
import io.micronaut.http.client.bind.TypedClientArgumentRequestBinder;
import jakarta.inject.Singleton;
import watchy_api.models.TemperatureUnit;

/**
 *
 * @author edward
 */
 @Singleton
public class TemperatureUnitArgumentBinder implements TypedClientArgumentRequestBinder<TemperatureUnit>{

    @Override
    public Argument<TemperatureUnit> argumentType() {
        return Argument.of(TemperatureUnit.class);
    }

    @Override
    public void bind(ArgumentConversionContext<TemperatureUnit> context, ClientRequestUriContext uriContext, TemperatureUnit value, MutableHttpRequest<?> request) {
        String useValue = value == TemperatureUnit.C ? "metric" : "imperial";
        uriContext.addQueryParameter("units", useValue);
    }

}
