package type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Fragment {
    private Object d;
    private Object r1;
    private Object r2;
    private boolean mystic;
}
