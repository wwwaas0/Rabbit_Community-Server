package rabbit.umc.com.demo.home.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommunityHomeResV2 {


    private List<MainMissionDtoV2> mainMission;
    private List<PopularArticleDtoV2> popularArticle;
    private List<Long> userHostCategory;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class MainMissionDtoV2 {
        private Long mainMissionId;
        private String mainMissionTitle;
        private String dDay;
        private String topRankUser;
        private Long missionCategoryId;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class PopularArticleDtoV2 {
        private Long articleId;
        private String articleTitle;
        private String uploadTime;
        private int likeCount;
        private int commentCount;

    }
}