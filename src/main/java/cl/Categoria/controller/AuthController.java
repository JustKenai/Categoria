package cl.Categoria.controller;

import cl.Categoria.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        if ("admin".equals(request.getUsername()) && "1234".equals(request.getPassword())) {

            UserDetails userDetails = User.builder()
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .roles("USER")
                    .build();

            String token = jwtService.generateToken(userDetails);
            return ResponseEntity.ok(token);
        }

        return ResponseEntity.status(401).body("Credenciales incorrectas");
    }
}

class LoginRequest {
    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}