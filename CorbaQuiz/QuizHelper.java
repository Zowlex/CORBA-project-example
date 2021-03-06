package CorbaQuiz;


/**
* CorbaQuiz/QuizHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from quiz.idl
* dimanche 2 d�cembre 2018 22 h 13 GMT+01:00
*/

abstract public class QuizHelper
{
  private static String  _id = "IDL:CorbaQuiz/Quiz:1.0";

  public static void insert (org.omg.CORBA.Any a, CorbaQuiz.Quiz that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CorbaQuiz.Quiz extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [7];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "id",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "question",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "answer_1",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "answer_2",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "answer_3",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[5] = new org.omg.CORBA.StructMember (
            "answer_4",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[6] = new org.omg.CORBA.StructMember (
            "correct_answer",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (CorbaQuiz.QuizHelper.id (), "Quiz", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CorbaQuiz.Quiz read (org.omg.CORBA.portable.InputStream istream)
  {
    CorbaQuiz.Quiz value = new CorbaQuiz.Quiz ();
    value.id = istream.read_long ();
    value.question = istream.read_string ();
    value.answer_1 = istream.read_string ();
    value.answer_2 = istream.read_string ();
    value.answer_3 = istream.read_string ();
    value.answer_4 = istream.read_string ();
    value.correct_answer = istream.read_long ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CorbaQuiz.Quiz value)
  {
    ostream.write_long (value.id);
    ostream.write_string (value.question);
    ostream.write_string (value.answer_1);
    ostream.write_string (value.answer_2);
    ostream.write_string (value.answer_3);
    ostream.write_string (value.answer_4);
    ostream.write_long (value.correct_answer);
  }

}
