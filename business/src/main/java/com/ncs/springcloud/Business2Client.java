@FeignClient("business2")
public interface StoreClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getTest();
    
}
