package alg.dynprg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test {

	public static void main1(String[] args) {
		String a = "3047256178414111539177892760416692371259184968596637101103470800691502127201206721753122686940948803915675049171249304581375612480754088028743832118763871935918417838829464707988489337429769611583833111684200745242063405701863222291780789306835766301890077485794933582184378775464518979959743359102141148662382408255253620650487176842801539394331458364031592213135740649454814982046786039395348848445769966417133647064866949189491066937591518907345678909773910972589196129055048855475649533694935951844856938244654313359320460469516821788324682888573791077411599764011075784920933641348884356966351475261443466247455025019252086769714642506572126969066430058968591788726159085446602156489564071886009742910372369813278342211511941722136648917170212494526671092030481544089862933890271924723192869393409558351184698970339087794416160184528405280293744029986132319011295653370647972229405001682588995176537774616262140795055979517433776085714177858363165843323310647101384809334561196539909577504309139685378761189410222798411087223651219470857113897310408007635740486554178410238800252689595412058577169081109645903635524928254805398891792386770002967761073090550132964823850304464672103776962806232852370670309853395949737558032824361632179843385017344627332557567731002041706039333732307635083529027623539116442611323503041818163841915716743038286645730504121278293170060104206224836400658420643625935112049246611294242162208426090364088712014313996176950078566752200488171301206916830452694729103357223040271875675033755316577427166495381432926909274573437248079947389551378543916721909213828454583046482282046806872083709575668506048054002975304955354985211211264938807844524101596601157573495696477148722207235612102934659343107414922094915268812831377465527333004052659892859694836384944379724097408146026356035228249320668078513571806700245892274455835401843269613304355466561546803871455042234590764926722326932158453231986433559197023954176644616281771591423693192241053854367228870530848941212609468718760569830719450762893381523382324852399752927920365145613699560339582193179698222969473637081673894366918745158691104745583816379116511264231523391848438332076385257639327634958086008038373519285878160494014466992569962128829312384544261638207409040319211973417558257011735804814613377174264573562857062938423786873232828164145801938398973526746417392152259802506928303787822148497632404993568719158027270554938121917888538265984785940893283376095126904076838746856868395360698781157946904241035371239813413865378011119242334202403280305971384874224669605501499639598361450708580267132920533725276595377131935555002062996762660135398133975271421949783689984695152216970215288517636587013754116660225980431165924802264920514814718497095839445008940209313926548607849148861770208385773492749322421938069218402860080627931640596164820210836911909853682716802111864419391202780728776127406888459561125012448297364986056922255269";
		
		System.out.println(Test.class.getClassLoader().getClass().getCanonicalName());
		
//		System.out.println(Test.class.getClassLoader().getClass().getClassLoader().getClass().getCanonicalName());
		System.out.println(a.length());
		
		
		List<Integer> list = new ArrayList<Integer>();
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		ListIterator<Integer> ite = list.listIterator();
		
		list.add(18);

		int count = 10;
		while(ite.hasNext()){
			
			if(list.size() < 10)
			{
				list.add(19);
			}
			else{
				break;
			}
			
//			System.out.println(ite.next());
		}
		
		Iterator it = list.iterator();
		
		/*while(it.hasNext()){
			System.out.println(it.next());
		}
		*/
		System.out.println("end");
		
	}
	
	public static void main(String[] args) {
		
		String s = "hello";
		
		String s1 = "hello";
		
		String s2 = new String("Hello");
		
		if (s == s1)
		{
			System.out.println("Equal");
		}
		else {
			System.out.println("Not equal");
		}
	}

}
