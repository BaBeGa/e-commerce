package com.th.ac.ku.kps.cpe.ecommerce.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "z_question", schema = "e-commerce_01")
public class ZQuestionEntity {
    private int idQuestion;
    private String question;
    private String choice1;
    private String choice2;
    private String choice3;
    private int correctChoice;

    @Id
    @Column(name = "id_question")
    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    @Basic
    @Column(name = "question")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Basic
    @Column(name = "choice1")
    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    @Basic
    @Column(name = "choice2")
    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    @Basic
    @Column(name = "choice3")
    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    @Basic
    @Column(name = "correct_choice")
    public int getCorrectChoice() {
        return correctChoice;
    }

    public void setCorrectChoice(int correctChoice) {
        this.correctChoice = correctChoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZQuestionEntity that = (ZQuestionEntity) o;
        return idQuestion == that.idQuestion &&
                correctChoice == that.correctChoice &&
                Objects.equals(question, that.question) &&
                Objects.equals(choice1, that.choice1) &&
                Objects.equals(choice2, that.choice2) &&
                Objects.equals(choice3, that.choice3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestion, question, choice1, choice2, choice3, correctChoice);
    }
}
