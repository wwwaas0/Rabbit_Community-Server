package rabbit.umc.com.demo.mission;

import lombok.Getter;
import lombok.Setter;
import rabbit.umc.com.config.BaseTimeEntity;
import rabbit.umc.com.demo.Status;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Table(name = "mission_category")
public class MissionCategory extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "mission_category_id")
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "varchar(20) default 'ACTIVE'")
    private Status status;

}