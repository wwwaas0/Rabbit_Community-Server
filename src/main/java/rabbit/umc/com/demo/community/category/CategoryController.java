package rabbit.umc.com.demo.community.category;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rabbit.umc.com.config.apiPayload.BaseException;
import rabbit.umc.com.config.apiPayload.BaseResponse;
import rabbit.umc.com.demo.community.dto.PatchCategoryImageReq;
import rabbit.umc.com.utils.JwtService;

@Api(tags = {"카테고리 관련 Controller"})
@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final JwtService jwtService;

    @Tag(name = "changeCategoryImage")
    @Operation(summary = "카테고리 대표 이미지 변경 API")
    @ApiResponses({
            @ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @ApiResponse(responseCode = "JWT4001", description = "JWT 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @ApiResponse(responseCode = "JWT4002", description = "JWT 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @ApiResponse(responseCode = "JWT4003", description = "권한 없는 접근",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @ApiResponse(responseCode = "CATEGORY4001", description = "존재하지 않는 카테고리",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "categoryId", description = "이미지 변경할 카테고리 id"),
            @Parameter(name = "PatchCategoryImageReq", description = "새로운 이미지 url"),
    })
    @PatchMapping("/host/main-image/{categoryId}")
    public BaseResponse editCategoryImage(@PathVariable("categoryId") Long categoryId,
                                          @RequestBody PatchCategoryImageReq patchCategoryImageReq){
        try {
            Long userId = (long) jwtService.getUserIdx();
            categoryService.editCategoryImage(userId, categoryId, patchCategoryImageReq);

            return new BaseResponse<>("카테고리 " + categoryId + "번 사진 수정완료되었습니다.");
        }catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

}

