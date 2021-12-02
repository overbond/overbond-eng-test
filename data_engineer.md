# Coding Challenge (Data Engineer Role)
The following is a coding challenge that will give us some insight into your coding and problem solving abilities

## Challenge
You will be provided with a raw unstructured data csv file. In this file, the data is stored as tags across multiple lines and multiple lines span a single record. Specifically, every 10 lines constitute to a single record.
For instance, row 1 to 10 refers to one record, row 11 to 20 refers to another record and so forth 

### Goal
The goal of this challenge is to parse the given csv file and store it as structured csv (1 row per record) with the listed structure below. The details of each required field is also provided below.

| Field Names | Details |
|-------------|----------|
| ISIN | a string prefixed with **ISn** |
| DataDATE | a string prefixed with **Dt** |
| Row in Tip | row # of where the ISIN is located in the data file |
| Name | a string prefixed with **NAm** in third last or second last of the block | 
| Trading Type | a string prefixed with **NAm** in third row of the block |
| RIKS | a string prefixed with **SNm** | 
| Issue Currency | a string prefixed with **CUi** | 
| Trading Currency | a string prefixed with **CUt** |
| Last trading Day | a number sequence prefixed with **TTd** |
| Issuance Date | a string prefixed wtih **DIs** |
| Maturty Date | a string prefixed with **DMa** | 
| Amount Outstanding | a string prefixed with **AOs** |
| Coupon Rate | a string prefixed with **RCp** |
| Maturty Date | a number sequence prefixed with **DNc** |
| Reddem Value | a number prefixed with **Mv** |
| Last Coupon Date | a number sequence prefixed with **LCOd** |
| Next Coupon Date | a number sequence prefixed with **DNc** |
| # Coupons | a number prefixed with **CFq** |
| Base Value | a number prefixed with **VBa** | 
| CleanBid | a number prefixed with **BPr** | 
| CleanAsk | a number prefixed with **APl** |
| Last Price | a number prefixed with **Pl** |

### Sample Input
| | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | | |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| BDSr | i2 | NAmGITS |
| BDx | i138 | Si6 | s2 | SYmIS | NAmNasdaq Iceland hf. | CNyIS | MIcXICE |
| BDm | i896 | Si006178 | s2 | Ex138 | NAmIceland Cash Bond Trading | SYmICECB | TOTa+0000 | LDa20190406 | MIcXICE |
| BDIs | i15020 | SiRIK | s2 | ISsRIK | NAmRíkissjóður Íslands | CNyIS | MLEi254900IPCJWRC6XAJN15 |
| BDt | i2878286 | SiRIKS_26_0216 | s2 | Ex138 | Mk896 | INiRIK013ICECBCSH | SYmRIKS 26 0216 | NAmRíkissjóður 26 0216 | SNmRIKS 26 0216 | ISnIS0000030732 | ISi15020 | ISsRIK | CUiISK | CUtISK | PRt3 | VOd2 | LDa20181129 | Cf1 | TTd20260216 | CFcDBFTFR | IEtBullet loan | NMv1 | ITSz347 | NDp4 | NDc3 | MPmN | MPaN | NDTp4 | NDTc3 | CLId21232 | CNyIS | ITStN | SSc2 | STy4 | AUmY | TRaY | INrY | PTaN | PTb2 | OXCl0 | RLoY | IaN | FxN | IqN | TUsN | MSc449 | LSz1 |
| BDu | i2878286 | SiRIKS_26_0216 | s2 | IICtISIN | "FISnENDURLAN/1\ | 5 TB 20260216" | MIFrBOND | MCTyOTHR | MLIqN | MTcN | MLPr100000000 | MLPo0 | MSPo0 | MJCjN | MQu10000 | MBTyEUSB | MBPs0 | MCStN |
| BDBo | i2878286 | SiRIKS_26_0216 | s2 | BTy1 | DIs20180216 | AOs37879700000 | DMa20260216 | RCp1.5 | DNc20220216 | DCm5 | Mv100 | HaN | RDd0 | RDt1 | NRd2 | CPFrN | LCOd20260216 | Fv1 | CFq1 | Cc8 | RIxCPI_IS | FCd20190216 | VBa446.98571 | Vm1 | MDo255 | SSDaN | FIt3 | DAd20180216 |
| BDLi | i14702 | SiISTO | s2 | LSt433 | SYmISTO | NAmICE Inflation-linked Treasury Bonds | LCyISK | TCeY |
| BDLi | i14704 | SiICE_INFLATION-LINKED_TREASURY_BO | s2 | LSt434 | PAi14702 | NAmICE Inflation-linked Treasury Bonds | LCyISK | TCeN |
| m | i2878286 | t180000.355 | Dt20210827 | ISOcY | ISOtY | d0.035 | BPr106.45 | APl106.67 | Pl106.56 | Ph106.56 | LOp106.56 | Pd0.005 | q1 | o60000000 | Rq60000000 | HPm107.37 | HPMd20210803 | LPm106.4 | LPMd20210819 | HPy109.175 | HPYd20210429 | LPy106.4 | LPYd20210819 | LTd20210827 | LPd20210827 |

### Sample Output
| ISIN | DataDATE | Row in Tip | Name | Trading Type | RIKS | Issue Currency | Trading Currency | Last trading Day | Issuance Date | Maturty Date | Amount Outstanding | Coupon Rate | Maturty Date | Reddem Value | Last Coupon Date | Next Coupon Date | # Coupons | Base Value | CleanBid | CleanAsk | Last Price |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
IS0000030732 | 27-Aug-21 | 5 | ICE Inflation-linked Treasury Bonds | Iceland Cash Bond Trading | RIKS 26 0216 | ISK | ISK | 16-Feb-26 | 16-Feb-18 | 16-Feb-26 | 37879700000 | 1.5 | 16-Feb-22 | 100 | 16-Feb-26 | 16-Feb-22 | 1 | 446.98571 | 106.45 | 106.67 | 106.56 |

## Technical Spec
Use any language with which you are most comfortable. Overbond is a Rails shop, so if you can write the solution in Ruby, great! But it's not required. **The allocated time is ~ 1 day**

Please organize, design, test and document your code as if it were going into production. Write your README as if it was for a production service and include the following items:

* Reasoning behind your technical choices
* Trade-offs you might have made or what you might do differently if you were to spend additional time on the project

## How we review
Remember, this is production level code. The aspects of your code we will judge include:

* **Functionality**: Does the application do what was asked?
* **Code quality**: Is the code simple and easy to understand?
* **Testing**: Are there automated tests? Do they provide sufficient coverage?
* **Documentation**: Is a README file included? Does it specify how to execute the app? Does it describe your approach sufficiently?

## Submission
Email us a zip file containing your solution