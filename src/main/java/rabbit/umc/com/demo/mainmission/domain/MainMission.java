package rabbit.umc.com.demo.mainmission.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rabbit.umc.com.demo.base.BaseTimeEntity;
import rabbit.umc.com.demo.base.Status;
import rabbit.umc.com.demo.community.domain.Category;
import javax.persistence.*;
import java.time.LocalDate;
import rabbit.umc.com.demo.mainmission.domain.mapping.MainMissionUsers;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "main_mission")
public class MainMission extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "main_mission_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private Boolean lastMission;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;

    private String hostUserName;

    @Column(nullable = false)
    private LocalDate startAt;
    @Column(nullable = false)
    private LocalDate endAt;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    @Builder.Default
    private Status status = Status.ACTIVE;

    @OneToMany(mappedBy = "mainMission")
    private List<MainMissionUsers> mainMissionUsers;

    //비즈니스 로직
    public void inActive(){
        this.status = Status.INACTIVE;
    }

    public void changeLastMission(boolean lastMission){
        this.lastMission = lastMission;
    }
}
