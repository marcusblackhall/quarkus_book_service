package com.iamatum.quarkus.microservices.book;

import com.iamatum.quarkus.microservices.client.IsbnThirteen;
import com.iamatum.quarkus.microservices.client.NumberProxy;
import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Mock
@RestClient
public class MockNumberProxy implements NumberProxy {
    @Override
    public IsbnThirteen generateIsbnnumbers() {
        IsbnThirteen thirteen = new IsbnThirteen();
        thirteen.isbn13 = "13-123456";
        return thirteen;
    }
}
