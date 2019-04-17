package ru.trandefil.spring.resource;

public class AuthResourceClient {

/*    public static AuthResource getInstance(final String url){
        final FormHttpMessageConverter converter = new FormHttpMessageConverter();
        final HttpMessageConverters converters = new HttpMessageConverters(converter);
        final ObjectFactory<HttpMessageConverters> objectFactory = () -> converters;
        final CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        final okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient().newBuilder();
        builder.cookieJar(new JavaNetCookieJar(cookieManager));

        Feign.builder()
                .client(new OkHttpClient(builder.build()))
                .contract(new SpringMvcContract())
    }*/

}
