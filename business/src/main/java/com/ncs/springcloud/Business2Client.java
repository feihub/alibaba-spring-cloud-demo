@FeignClient("business2", fallback = Business2ClientFallback.class)
public interface Business2Client {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getTest();
    
}

static class Business2ClientFallback implements Business2Client {
    @Override
    public String getTest() {
        return "business2-fallback";
    }
}
