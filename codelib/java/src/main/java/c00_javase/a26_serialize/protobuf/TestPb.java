//package c00_javase.a26_serialize.protobuf;
//
//import java.util.List;
//
//import com.google.protobuf.InvalidProtocolBufferException;
//
//import c00_javase.a05.Person;
//
//public class TestPb {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		PersonProbuf.Person.Builder builder = PersonProbuf.Person.newBuilder();
//		builder.setEmail("kkk@email.com");
//		builder.setId(1);
//		builder.setName("TestName");
//		builder.addPhone(PersonProbuf.Person.PhoneNumber.newBuilder().setNumber("131111111")
//				.setType(PersonProbuf.Person.PhoneType.MOBILE));
//		builder.addPhone(PersonProbuf.Person.PhoneNumber.newBuilder().setNumber("011111")
//				.setType(PersonProbuf.Person.PhoneType.HOME));
//
//		Person person = builder.build();
//		byte[] buf = person.toByteArray();
//
//		try {
//			Person person2 = PersonProbuf.Person.parseFrom(buf);
//			System.out.println(person2.getName() + ", " + person2.getEmail());
//			List<PhoneNumber> lstPhones = person2.getPhoneList();
//			for (PhoneNumber phoneNumber : lstPhones) {
//				System.out.println(phoneNumber.getNumber());
//			}
//		} catch (InvalidProtocolBufferException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.out.println(buf);
//
//	}
//
//}