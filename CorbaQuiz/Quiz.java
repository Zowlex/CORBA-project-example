package CorbaQuiz;


/**
* CorbaQuiz/Quiz.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from quiz.idl
* dimanche 2 d�cembre 2018 22 h 13 GMT+01:00
*/

public final class Quiz implements org.omg.CORBA.portable.IDLEntity
{
  public int id = (int)0;
  public String question = null;
  public String answer_1 = null;
  public String answer_2 = null;
  public String answer_3 = null;
  public String answer_4 = null;
  public int correct_answer = (int)0;

  public Quiz ()
  {
  } // ctor

  public Quiz (int _id, String _question, String _answer_1, String _answer_2, String _answer_3, String _answer_4, int _correct_answer)
  {
    id = _id;
    question = _question;
    answer_1 = _answer_1;
    answer_2 = _answer_2;
    answer_3 = _answer_3;
    answer_4 = _answer_4;
    correct_answer = _correct_answer;
  } // ctor

} // class Quiz