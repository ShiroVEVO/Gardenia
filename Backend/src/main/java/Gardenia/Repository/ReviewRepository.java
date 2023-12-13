package Gardenia.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Gardenia.DTO.ReviewDTO;
import Gardenia.Model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    public List<ReviewDTO> findReviewBy();

    public Optional<ReviewDTO> findByIdReview(Integer id);

    public List<ReviewDTO> findReviewByScore(Integer id);

    @Query("SELECT new Gardenia.DTO.ReviewDTO(re.comment, re.commentDate, re.score) FROM Review re WHERE re.commentDate BETWEEN :initialDate AND :finalDate")
    public List<ReviewDTO> findRequestByDate(@Param("initialDate") Date initialDate,
            @Param("finalDate") Date finalDate);

}
