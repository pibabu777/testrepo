
    import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
    
@RestController
@RequestMapping("/api")
public class sample {

    


    @PostMapping("/submit")
    public ResponseEntity<String> receiveData(@RequestBody Map<String, String> data) {
        String name = data.get("name");
        String role = data.get("role");
        return ResponseEntity.ok("Received: " + name + " as " + role);
    }
}

}


