import com.cdainfo.login.ILoginRepo;
import com.cdainfo.login.LoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class LoginTest {
    @Test
    public void authenticate_goodCredentials_returnSuccessMessage(){
        ILoginRepo LoginRepoMock = Mockito.mock(ILoginRepo.class);
        when(LoginRepoMock.authenticate(any(String.class), any(String.class))).thenReturn("OK");

        LoginService loginService = new LoginService(LoginRepoMock);
        String result = loginService.authenticate("jarroyo", "123456");
        Assertions.assertEquals("Exito!!!", result);
    }
}
