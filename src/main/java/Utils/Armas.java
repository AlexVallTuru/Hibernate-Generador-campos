/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author Alex
 */
public class Armas {

    public static String generadorArmasPrincipales(int randomNumero) {
        String[] armasPrincipales = {
            "AK48",
            "M16",
            "SCAR",
            "MP5",
            "Uzi",
            "P90",
            "Galil",
            "FAMAS",
            "AUG",
            "G36C",
            "AR15",
            "M4A1",
            "FN FAL",
            "Steyr AUG",
            "SG553",
            "SIG 550",
            "HK416",
            "TAR21",
            "AK74",
            "ACR",
            "Kriss Vector",
            "PPSh41",
            "Thompson",
            "Sten",
            "Micro Uzi",
            "Krinkov",
            "AKS74U",
            "RPK",
            "M60",
            "M249",
            "PKM",
            "Negev",
            "XM8",
            "HK417",
            "M14",
            "L85A2",
            "G3",
            "FN SCARH",
            "FN SCARL",
            "XM177",
            "M3 Grease Gun",
            "AKS74",
            "IMI Tavor",
            "QBZ95",
            "Type 56",
            "Type 81",
            "M1 Garand",
            "M1918 BAR",
            "M1919 Browning",
            "M2 Browning",
            "M60E4",
            "M240B",
            "RPD",
            "Bren Gun",
            "DP28",
            "FG42",
            "Lewis Gun",
            "CETME",
            "FAL Para",
            "XM29",
            "XM25",
            "HK G11",
            "QBZ03",
            "VHS2",
            "Groza",
            "AS Val",
            "AEK971",
            "AN94",
            "G11K2",
            "OTs14",
            "GSh18",
            "Glock 18",
            "CZ Scorpion Evo",
            "MAC10",
            "TEC9",
            "Colt Commando",
            "Sterling",
            "AK103",
            "AK104",
            "AK105",
            "AK107",
            "AK108",
            "AK9",
            "KRISS Sphinx",
            "Steyr TMP",
            "Bizon",
            "H&K MP7",
            "Magpul PDR",
            "CZ Skorpion",
            "SR3M",
            "PP19",
            "RPK74",
            "Stoner 63",
            "HK21",
            "HK23",
            "HK25",
            "HK121",
            "M27 IAR",
            "L86A2",
            "QBB95",
            "Miniuzi"
        };
        return armasPrincipales[randomNumero];
    }

    public static String generadorArmasSecundarias(int randomNumero) {
        String[] armasSecundarias = {
            "Glock 17",
            "Beretta 92FS",
            "SIG Sauer P226",
            "M1911",
            "CZ75",
            "Walther P99",
            "Desert Eagle",
            "Magnum Research BFR",
            "Smith Wesson Model 500",
            "Ruger Redhawk",
            "Colt Anaconda",
            "Taurus Raging Bull",
            "FN FiveseveN",
            "Heckler & Koch USP",
            "Browning HiPower",
            "Tokarev TT33",
            "Makarov PM",
            "Stechkin APS",
            "CZ83",
            "Walther PP",
            "Luger P08",
            "Mauser C96",
            "Webley Revolver",
            "Smith Wesson Model 29",
            "Colt Detective Special",
            "Ruger SP101",
            "Smith Wesson Model 686",
            "Taurus Model 85",
            "Ruger LCR",
            "Charter Arms Bulldog",
            "KelTec P32",
            "Ruger LC9",
            "Glock 26",
            "Smith & Wesson Model 640",
            "Beretta Px4 Storm",
            "Springfield XD",
            "Walther PPS",
            "Kahr K9",
            "Heckler Koch P7",
            "Glock 43",
            "SIG Sauer P320",
            "CZ P10",
            "Ruger American Pistol",
            "Colt Defender",
            "Smith Wesson M&P Shield",
            "Smith Wesson M&P9",
            "Heckler Koch VP9",
            "FN FNP",
            "Beretta M9A3",
            "CZ 75D Compact",
            "Walther CCP",
            "Springfield Armory EMP",
            "Colt Mustang",
            "Kimber Solo",
            "North American Arms MiniRevolver",
            "Taurus Judge",
            "Smith & Wesson Governor",
            "KelTec PMR30",
            "Heckler & Koch MK23",
            "FNX45",
            "Glock 30",
            "Springfield Armory XDS",
            "Kahr CM9",
            "Ruger LCP",
            "Colt Mustang Pocketlite",
            "Ruger SR22",
            "Smith Wesson Model 41",
            "Browning Buck Mark",
            "Beretta M9",
            "Smith Wesson M&P",
            "Heckler Koch P2000",
            "Walther P99 AS",
            "SIG Sauer SP2022",
            "Glock 19",
            "CZ 75 SP01",
            "Smith Wesson Model 10",
            "Taurus PT92",
            "Walther PPQ",
            "Springfield Armory XD",
            "Ruger Blackhawk",
            "Smith Wesson Model 15",
            "Heckler Koch HK45",
            "Colt Peacemaker",
            "Remington New Model Army",
            "Colt Single Action Army",
            "Webley Scott Revolver",
            "Smith Wesson Model 25",
            "Taurus Model 44",
            "Ruger GP100",
            "Beretta 93R",
            "Colt Single Action Army",
            "FN FiveseveN",
            "Heckler Koch VP9",
            "IMI Desert Eagle",
            "Kimber Warrior",
            "Smith Wesson Model 500",
            "Steyr M9A1",
            "Taurus Judge",
            "Walther P99",
            "SIG Sauer P226",
            "Remington 870"};
        return armasSecundarias[randomNumero];
    }

    //TODO Falta Generar Armas Cuerpo a cuerpo, estas son armas secundarias pero por ahora...
    public static String generadorArmaCQC(int randomNumero) {
        String[] armaCQC = {
            "Glock 17",
            "Beretta 92FS",
            "SIG Sauer P226",
            "M1911",
            "CZ75",
            "Walther P99",
            "Desert Eagle",
            "Magnum Research BFR",
            "Smith Wesson Model 500",
            "Ruger Redhawk",
            "Colt Anaconda",
            "Taurus Raging Bull",
            "FN FiveseveN",
            "Heckler & Koch USP",
            "Browning HiPower",
            "Tokarev TT33",
            "Makarov PM",
            "Stechkin APS",
            "CZ83",
            "Walther PP",
            "Luger P08",
            "Mauser C96",
            "Webley Revolver",
            "Smith Wesson Model 29",
            "Colt Detective Special",
            "Ruger SP101",
            "Smith Wesson Model 686",
            "Taurus Model 85",
            "Ruger LCR",
            "Charter Arms Bulldog",
            "KelTec P32",
            "Ruger LC9",
            "Glock 26",
            "Smith & Wesson Model 640",
            "Beretta Px4 Storm",
            "Springfield XD",
            "Walther PPS",
            "Kahr K9",
            "Heckler Koch P7",
            "Glock 43",
            "SIG Sauer P320",
            "CZ P10",
            "Ruger American Pistol",
            "Colt Defender",
            "Smith Wesson M&P Shield",
            "Smith Wesson M&P9",
            "Heckler Koch VP9",
            "FN FNP",
            "Beretta M9A3",
            "CZ 75D Compact",
            "Walther CCP",
            "Springfield Armory EMP",
            "Colt Mustang",
            "Kimber Solo",
            "North American Arms MiniRevolver",
            "Taurus Judge",
            "Smith & Wesson Governor",
            "KelTec PMR30",
            "Heckler & Koch MK23",
            "FNX45",
            "Glock 30",
            "Springfield Armory XDS",
            "Kahr CM9",
            "Ruger LCP",
            "Colt Mustang Pocketlite",
            "Ruger SR22",
            "Smith Wesson Model 41",
            "Browning Buck Mark",
            "Beretta M9",
            "Smith Wesson M&P",
            "Heckler Koch P2000",
            "Walther P99 AS",
            "SIG Sauer SP2022",
            "Glock 19",
            "CZ 75 SP01",
            "Smith Wesson Model 10",
            "Taurus PT92",
            "Walther PPQ",
            "Springfield Armory XD",
            "Ruger Blackhawk",
            "Smith Wesson Model 15",
            "Heckler Koch HK45",
            "Colt Peacemaker",
            "Remington New Model Army",
            "Colt Single Action Army",
            "Webley Scott Revolver",
            "Smith Wesson Model 25",
            "Taurus Model 44",
            "Ruger GP100",
            "Beretta 93R",
            "Colt Single Action Army",
            "FN FiveseveN",
            "Heckler Koch VP9",
            "IMI Desert Eagle",
            "Kimber Warrior",
            "Smith Wesson Model 500",
            "Steyr M9A1",
            "Taurus Judge",
            "Walther P99",
            "SIG Sauer P226",
            "Remington 870"};
        return armaCQC[randomNumero];
    }

    public static String generadorPrestigios(int randomNumero) {
        String[] prestigios = {
            "Subteniente I",
            "Subteniente II",
            "Subteniente III",
            "Subteniente IV",
            "Subteniente V",
            "Suboficial Mayor I",
            "Suboficial Mayor II",
            "Suboficial Mayor III",
            "Suboficial Mayor IV",
            "Suboficial Mayor V"};

        return prestigios[randomNumero];
    }
}
