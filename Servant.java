import java.io.IOException;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import CorbaQuiz.App;
import CorbaQuiz.AppHelper;
import CorbaQuiz.Quiz;

public class Servant {
	// Runtime.getRuntime().exec("cmd");
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String mainmenu = "                          Welcome to Quiz App                     \n" + "1.Edit Quizezz\n"
				+ "2.Play\n" + "3.Exit";
		try {
			// context object creation
			Context ctx = new InitialContext();
			// get context
			ctx.addToEnvironment(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.cosnaming.CNCtxFactory");
			ctx.addToEnvironment("java.naming.provider.url", "iiop://localhost:900");
			// get referance
			Object ref = ctx.lookup("qz");
			// casting object to corba object
			App stub = AppHelper.narrow((org.omg.CORBA.Object) ref);
			// implementing distant service
			boolean exit = false;
			do {//console clear
				for (int i = 0; i < 50; ++i)
				System.out.println();
				//begin
				System.out.println(mainmenu);
				int choice = sc.nextInt();
				switch (choice) {
				case (1): {
					for (int i = 0; i < 50; ++i)
						System.out.println();
					Scanner sc1 = new Scanner(System.in);
					boolean return_to_mainmenu = false;
					do {
						String submenu1 = "1.Add question\n" + "2.Modify a question\n" + "3.Show question (by id)\n"
								+ "4.return to main menu";
						System.out.println(submenu1);
						int subchoice = sc1.nextInt();
						switch (subchoice) {
						case (1): {
							for (int i = 0; i < 50; ++i)
								System.out.println();
							// add id
							System.out.println("Enter Id:");
							int id = sc1.nextInt();
							// add question
							System.out.println("Enter Question:");
							String question = sc1.nextLine();
							// add answer1
							System.out.println("Enter answer 1:");
							String answer1 = sc1.nextLine();
							// add answer2
							System.out.println("Enter answer 2:");
							String answer2 = sc1.nextLine();
							// add answer3
							System.out.println("Enter answer 3:");
							String answer3 = sc1.nextLine();
							// add answer4
							System.out.println("Enter answer 4:");
							String answer4 = sc1.nextLine();
							// add correct answer
							System.out.println("Enter correct answer:");
							int correctanswer = sc1.nextInt();
							// add quiz
							stub.setQuiz(new Quiz(id, question, answer1, answer2, answer3, answer4, correctanswer));
							System.out.println("Question Added !!!");
							break;
						}
						case (2): {
							for (int i = 0; i < 50; ++i)
								System.out.println();
							// add id
							System.out.println("Enter Id:");
							int id = sc1.nextInt();
							// add question
							System.out.println("Enter Question:");
							String question = sc1.nextLine();
							// add answer1
							System.out.println("Enter answer 1:");
							String answer1 = sc1.nextLine();
							// add answer2
							System.out.println("Enter answer 2:");
							String answer2 = sc1.nextLine();
							// add answer3
							System.out.println("Enter answer 3:");
							String answer3 = sc1.nextLine();
							// add answer4
							System.out.println("Enter answer 4:");
							String answer4 = sc1.nextLine();
							// add correct answer
							System.out.println("Enter correct answer:");
							int correctanswer = sc1.nextInt();
							// add quiz
							stub.updateQuiz(new Quiz(id, question, answer1, answer2, answer3, answer4, correctanswer));
							System.out.println("Question modified !!!");
							break;
						}
						case (3): {
							for (int i = 0; i < 50; ++i)
								System.out.println();
							// add id
							System.out.println("Enter Id of the question you want to check:");
							int id = sc1.nextInt();
							// getquiz
							Quiz q;
							q = stub.getQuestion(id);
							String quiz = "Question : " + q.question + "\n" + "First Answer : " + q.answer_1 + "\n"
									+ "Second Answer : " + q.answer_2 + "\n" + "Third Answer : " + q.answer_3 + "\n"
									+ "Fourth Answer : " + q.answer_4 + "\n" + "Correct answer : " + q.correct_answer;
							System.out.println(quiz);
							Thread.sleep(2000);
							break;

						}
						case (4):
							return_to_mainmenu = true;
							break;

						}
					} while (!return_to_mainmenu);
					break;

				}
				case (2): {
					Scanner sc2 = new Scanner(System.in);
					// console clear
					for (int i = 0; i < 50; ++i)
						System.out.println();
					// play
					// get array of quizzez
					Quiz[] q;
					// iterator
					Quiz it;
					q = stub.getQuiz();
					int score = 0;
					for (int i = 0; i < q.length; i++) {
						System.out.println(q[i].question);
						System.out.println("1." + q[i].answer_1 + "\n" + "2." + q[i].answer_2 + "\n" + "3."
								+ q[i].answer_3 + "\n" + "4." + q[i].answer_4 + "\n");
						int answer_choice = sc2.nextInt();
						if (answer_choice == q[i].correct_answer)
							score++;
					}
					// console clear
					for (int i = 0; i < 50; ++i)
						System.out.println();
					System.out.println("You've got " + score + "/" + q.length);
					
					Thread.sleep(3000);
					break;
				}
				case (3):
					exit = true;
					break;
				}
			} while (!exit);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
