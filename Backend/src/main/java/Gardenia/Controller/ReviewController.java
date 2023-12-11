package Gardenia.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Gardenia.DTO.ReviewDTO;
import Gardenia.Model.Review;
import Gardenia.Service.ReviewService;
import Gardenia.Util.DateIntervals;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDTO> getAllReviews() {
        return reviewService.getAllDTO();
    }

    @GetMapping("/{id_review}")
    public Optional<ReviewDTO> getReviewById(@PathVariable("id_review") Integer id) {
        return reviewService.getDTOById(id);
    }

    /*
     * @PostMapping("/product")
     * public List<ReviewDTO> getReviewsByProduct(@RequestBody Product product) {
     * return new SomeData();
     * }
     */

    @GetMapping("/score/{score}")
    public List<ReviewDTO> getReviewsByScore(@PathVariable("score") Integer score) {
        return reviewService.getByScore(score);
    }

    @PostMapping("/date")
    public List<ReviewDTO> getReviewsByDate(@RequestBody DateIntervals dateIntervals) {
        return reviewService.getByDate(dateIntervals.getInitialDate(), dateIntervals.getFinalDate());
    }

    @PostMapping("/save")
    public Boolean saveReview(@RequestBody Review review) {
        return reviewService.save(review);
    }

    @DeleteMapping("/{id_review}")
    public void deleteReviewById(@PathVariable("id_review") Integer id) {
        reviewService.deleteById(id);
    }

    @PutMapping("/{id_review}")
    public Boolean updateReviewById(@PathVariable("id_review") Integer id, @RequestBody Review review) {
        return reviewService.updateById(review, id);
    }

}
