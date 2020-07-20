@FeignClient("business2")
public interface Business2Client {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getTest();
    
}
