@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/info")
    public Object getCurrentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }
}
