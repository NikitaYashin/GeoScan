package models;

import lombok.*;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
    private Long createdTime;
    private Long id;
    private Long modifiedTime;
    private String name;
    private String URL;
    private Long userId;
    private List<Long> vehiclesId;
}
