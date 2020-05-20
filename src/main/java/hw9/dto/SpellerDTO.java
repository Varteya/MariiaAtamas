package hw9.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class SpellerDTO {
    private int code;
    private int pos;
    private int row;
    private int col;
    private int len;
    private String word;
    private List<String> s;
}
