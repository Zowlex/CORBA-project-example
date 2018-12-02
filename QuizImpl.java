import java.util.ArrayList;
import java.util.ListIterator;

import CorbaQuiz.AppPOA;
import CorbaQuiz.Quiz;

public class QuizImpl extends AppPOA {
	ArrayList<Quiz> array;
	public QuizImpl() {
		 array= new ArrayList<Quiz>();
		 array.add(new Quiz(1001,"When was build the first electronic-digital computer?","1956","1939","1960","1899",2));
		 array.add(new Quiz(1002,"What was the first name of the keyboard?","Qwerty","Azerty","koukou","first keyboard",1));
		 array.add(new Quiz(1003,"Who made the first touch screen phone?","Steve Jobs","Steve Austin","Steve a3mal","Steve b na3na3",1));
		 
	}

	@Override
	public void setQuiz(Quiz q) {
		// TODO Auto-generated method stub
		array.add(q);

	}

	@Override
	public void updateQuiz(Quiz q) {
		// TODO Auto-generated method stub
		ListIterator<Quiz> iterator = array.listIterator();
		while (iterator.hasNext()) {
			Quiz currentq = iterator.next();
			if (q.id == currentq.id) {
				currentq = q;
				break;
			}
		}

	}

	@Override
	public Quiz[] getQuiz() {
		// TODO Auto-generated method stub
		Quiz[] q = new Quiz[array.size()];
		return array.toArray(q);
		
	}

	@Override
	public Quiz getQuestion(int id) {
		// TODO Auto-generated method stub
		ListIterator<Quiz> it = array.listIterator();
		while (it.hasNext()) {
			Quiz currentq = it.next();
			if (currentq.id == id)
				return currentq;
		}
		return null;
	}

}
