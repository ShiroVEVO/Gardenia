package Gardenia.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Gardenia.DTO.ReviewDTO;
import Gardenia.Model.Review;
import Gardenia.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<ReviewDTO> getAllDTO() {
        return reviewRepository.findReviewBy();
    }

    public Optional<ReviewDTO> getDTOById(Integer id) {
        return reviewRepository.findByIdReview(id);
    }

    public Optional<Review> getById(Integer id) {
        return reviewRepository.findById(id);
    }

    // public List<ReviewDTO> getByProduct(Product product){}

    public List<ReviewDTO> getByScore(Integer score) {
        return reviewRepository.findReviewByScore(score);
    }

    public List<ReviewDTO> getByDate(Date initialDate, Date finalDate) {
        return null;
    }

    public Boolean save(Review review) {
        reviewRepository.save(review);
        return true;
    }

    public void deleteById(Integer id) {
        reviewRepository.deleteById(id);
    }

    public Boolean updateById(Review review, Integer id) {
        Optional<Review> optionalReviewExisting = getById(id);
        if (optionalReviewExisting.isPresent()) {
            Review reviewExisting = optionalReviewExisting.get();
            reviewExisting.setComment(review.getComment());
            reviewExisting.setCommentDate(review.getCommentDate());
            reviewExisting.setScore(review.getScore());
            save(reviewExisting);
            return true;
        } else {
            return false;
        }
    }
}
