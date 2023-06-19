package com.farhad.example.stream.collectors;

import static com.farhad.example.stream.collectors.Area.Alaska;
import static com.farhad.example.stream.collectors.Area.Arizona;
import static com.farhad.example.stream.collectors.Area.California;
import static com.farhad.example.stream.collectors.Area.Colorado;
import static com.farhad.example.stream.collectors.Area.District_of_Columbia;
import static com.farhad.example.stream.collectors.Area.Florida;
import static com.farhad.example.stream.collectors.Area.Georgia;
import static com.farhad.example.stream.collectors.Area.Hawaii;
import static com.farhad.example.stream.collectors.Area.Idaho;
import static com.farhad.example.stream.collectors.Area.Illinois;
import static com.farhad.example.stream.collectors.Area.Indiana;
import static com.farhad.example.stream.collectors.Area.Iowa;
import static com.farhad.example.stream.collectors.Area.Kansas;
import static com.farhad.example.stream.collectors.Area.Kentucky;
import static com.farhad.example.stream.collectors.Area.Louisiana;
import static com.farhad.example.stream.collectors.Area.Maryland;
import static com.farhad.example.stream.collectors.Area.Massachusetts;
import static com.farhad.example.stream.collectors.Area.Michigan;
import static com.farhad.example.stream.collectors.Area.Minnesota;
import static com.farhad.example.stream.collectors.Area.Missouri;
import static com.farhad.example.stream.collectors.Area.Nebraska;
import static com.farhad.example.stream.collectors.Area.Nevada;
import static com.farhad.example.stream.collectors.Area.New_Jersey;
import static com.farhad.example.stream.collectors.Area.New_Mexico;
import static com.farhad.example.stream.collectors.Area.New_York;
import static com.farhad.example.stream.collectors.Area.North_Carolina;
import static com.farhad.example.stream.collectors.Area.Ohio;
import static com.farhad.example.stream.collectors.Area.Oklahoma;
import static com.farhad.example.stream.collectors.Area.Oregon;
import static com.farhad.example.stream.collectors.Area.Pennsylvania;
import static com.farhad.example.stream.collectors.Area.Tennessee;
import static com.farhad.example.stream.collectors.Area.Texas;
import static com.farhad.example.stream.collectors.Area.Virginia;
import static com.farhad.example.stream.collectors.Area.Washington;
import static com.farhad.example.stream.collectors.Area.Wisconsin;
import static com.farhad.example.stream.collectors.City.of;

import java.util.Arrays;
import java.util.List;

public class USA {
    
    public static List<City> CITIES = Arrays.asList(
            of("New York", New_York, 8_622_698),
            of("Los Angeles", California, 3_999_759),
            of("Chicago", Illinois, 2_716_450),
            of("Houston", Texas, 2_312_717),
            of("Phoenix", Arizona, 1_626_078),
            of("Philadelphia", Pennsylvania, 1_580_863),
            of("San Antonio", Texas, 1_511_946),
            of("San Diego", California, 1_419_516),
            of("Dallas", Texas, 1_341_075),
            of("San Jose", California, 1_035_317),
            of("Austin", Texas, 950_715),
            of("Jacksonville", Florida, 892_062),
            of("San Francisco", California, 884_363),
            of("Columbus", Ohio, 879_170),
            of("Fort Worth", Texas, 874_168),
            of("Indianapolis", Indiana, 863_002),
            of("Charlotte", North_Carolina, 859_035),
            of("Seattle", Washington, 724_745),
            of("Denver", Colorado, 704_621),
            of("Washington", District_of_Columbia, 693_972),
            of("Boston", Massachusetts, 685_094),
            of("El Paso", Texas, 683_577),
            of("Detroit", Michigan, 673_104),
            of("Nashville-Davidson", Tennessee, 667_560),
            of("Memphis", Tennessee, 652_236),
            of("Portland", Oregon, 647_805),
            of("Oklahoma City", Oklahoma, 643_648),
            of("Las Vegas", Nevada, 641_676),
            of("Louisville", Kentucky, 621_349),
            of("Baltimore", Maryland, 611_648),
            of("Milwaukee", Wisconsin, 595_351),
            of("Albuquerque", New_Mexico, 558_545),
            of("Tucson", Arizona, 535_677),
            of("Fresno", California, 527_438),
            of("Sacramento", California, 501_901),
            of("Mesa", Arizona, 496_401),
            of("Kansas City", Missouri, 488_943),
            of("Atlanta", Georgia, 486_290),
            of("Long Beach", California, 469_450),
            of("Omaha", Nebraska, 466_893),
            of("Raleigh", North_Carolina, 464_758),
            of("Colorado Springs", Colorado, 464_474),
            of("Miami", Florida, 463_347),
            of("Virginia Beach", Virginia, 450_435),
            of("Oakland", California, 425_195),
            of("Minneapolis", Minnesota, 422_331),
            of("Tulsa", Oklahoma, 401_800),
            of("Arlington", Texas, 396_394),
            of("New Orleans", Louisiana, 393_292),
            of("Wichita", Kansas, 390_591),
            of("Cleveland", Ohio, 385_525),
            of("Tampa", Florida, 385_430),
            of("Bakersfield", California, 380_874),
            of("Aurora", Colorado, 366_623),
            of("Anaheim", California, 352_497),
            of("Honolulu", Hawaii, 350_395),
            of("Santa Ana", California, 334_136),
            of("Riverside", California, 327_728),
            of("Corpus Christi", Texas, 325_605),
            of("Lexington-Fayette", Kentucky, 321_959),
            of("Stockton", California, 310_496),
            of("St. Louis", Missouri, 308_626),
            of("St. Paul", Minnesota, 306_621),
            of("Henderson", Nevada, 302_539),
            of("Pittsburgh", Pennsylvania, 302_407),
            of("Cincinnati", Ohio, 301_301),
            of("Anchorage", Alaska, 294_356),
            of("Greensboro", North_Carolina, 290_222),
            of("Plano", Texas, 286_143),
            of("Newark", New_Jersey, 285_154),
            of("Lincoln", Nebraska, 284_736),
            of("Orlando", Florida, 280_257),
            of("Irvine", California, 277_453),
            of("Toledo", Ohio, 276_491),
            of("Jersey City", New_Jersey, 270_753),
            of("Chula Vista", California, 270_471),
            of("Durham", North_Carolina, 267_743),
            of("Fort Wayne", Indiana, 265_904),
            of("St. Petersburg", Florida, 263_255),
            of("Laredo", Texas, 260_654),
            of("Buffalo", New_York, 258_612),
            of("Madison", Wisconsin, 255_214),
            of("Lubbock", Texas, 253_888),
            of("Chandler", Arizona, 253_458),
            of("Scottsdale", Arizona, 249_950),
            of("Reno", Nevada, 248_853),
            of("Glendale", Arizona, 246_709),
            of("Norfolk", Virginia, 244_703),
            of("Winston-Salem", North_Carolina, 244_605),
            of("North Las Vegas", Nevada, 242_975),
            of("Gilbert", Arizona, 242_354),
            of("Chesapeake", Virginia, 240_397),
            of("Irving", Texas, 240_373),
            of("Hialeah", Florida, 239_673),
            of("Garland", Texas, 238_002),
            of("Fremont", California, 234_962),
            of("Richmond", Virginia, 227_032),
            of("Boise City", Idaho, 226_570),
            of("Baton Rouge", Louisiana, 225_374),
            of("Des Moines", Iowa, 217_521)    
    );
}
