package Bo;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xiong
 */
@Data
public class user implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;

}
