package Gardenia.Model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer idReview;

    @Column(columnDefinition = "VARCHAR(400)")
    private String comment;

    @Column(nullable = false)
    private Date commentDate;

    @Column(columnDefinition = "TINYINT(1) UNSIGNED", nullable = false)
    private Integer score;

    @ManyToOne
    @JsonBackReference("review-request")
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;
}
