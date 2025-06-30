package cn.com.chinahitech.bjmarket.course.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDTO {
    private Integer cBankId;
    private Integer limit;
}
