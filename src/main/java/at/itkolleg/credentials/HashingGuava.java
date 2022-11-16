package at.itkolleg.credentials;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
/**
 * Diese konkrete Dekorierer Klasse HashingGuava legt eine konkrete Hashing Variante vor
 */
public class HashingGuava extends HashDecorator{

    /**
     * Konstruktor überreicht das mitgegebene Interface ExportCredentials an die Mutterklasse HashDecorator
     * @param exportCredentials ein Interface von ExportCredentials
     */
    public HashingGuava(ExportCredentials exportCredentials) {
        super(exportCredentials);
    }

    /**
     * Ruft die Mutterklassen Methode export auf und übergibt eine Liste von Credentials
     * @param credentialsList Liste von Credentials
     */
    @Override
    public void export(List<Credentials> credentialsList) {
        for(Credentials credential : credentialsList){
            String sha256hex = Hashing.sha256()
                    .hashString(credential.getPwd(), StandardCharsets.UTF_8)
                    .toString();
            credential.setPwd(sha256hex);
        }
        exportCredentials.export(credentialsList);
    }
}
