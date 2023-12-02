package rabbit.umc.com.demo.community.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityHomeRes {


    private List<MainMissionListDto> mainMission;
    private List<PopularArticleDto> popularArticle;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class MainMissionListDto {
        private Long mainMissionId;
        private String mainMissionTitle;
        private String categoryImage;
        private String categoryName;
        private String dDay;

    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class PopularArticleDto {
        private Long articleId;
        private String articleTitle;
        private String uploadTime;
        private int likeCount;
        private int commentCount;

    }
}