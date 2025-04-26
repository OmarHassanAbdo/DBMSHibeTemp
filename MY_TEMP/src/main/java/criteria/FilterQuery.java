package criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterQuery {
  private String field;
  private Object value ;
  private Operator op;
//  private String type;// int double boolean
}
