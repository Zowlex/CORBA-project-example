package CorbaQuiz;


/**
* CorbaQuiz/qzHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from quiz.idl
* dimanche 2 d�cembre 2018 22 h 13 GMT+01:00
*/

abstract public class qzHelper
{
  private static String  _id = "IDL:CorbaQuiz/qz:1.0";

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
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = CorbaQuiz.QuizHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (CorbaQuiz.qzHelper.id (), "qz", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CorbaQuiz.Quiz read (org.omg.CORBA.portable.InputStream istream)
  {
    CorbaQuiz.Quiz value = null;
    value = CorbaQuiz.QuizHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CorbaQuiz.Quiz value)
  {
    CorbaQuiz.QuizHelper.write (ostream, value);
  }

}
