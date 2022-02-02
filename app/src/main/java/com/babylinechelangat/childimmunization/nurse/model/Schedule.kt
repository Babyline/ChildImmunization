package com.babylinechelangat.childimmunization.nurse.model

data class Schedule(
    val age: String,
    val scheduleDate: Long,
    val protectedAgainst: String,
    val vaccine: String,
) {
    companion object {
        enum class ProtectedAgainst {
            Tuberculosis,
            Polio,
            Diphtheria,
            HepatitisB,
            Pertussis,
            Tetanus,
            Measles,
            HaemophilusInfluenzae,
            Mumps,
            Rubella,
            VitaminADeficiency
        }

        enum class Vaccine {
            BCG,
            OPV_0,
            OPV_1,
            OPV_2,
            OPV_3,
            DPT_1,
            DPT_2,
            DPT_3,
            HepatitisB_1,
            HepatitisB_2,
            HepatitisB_3,
            Hib_1,
            Hib_2,
            Hib_3,
            Measles,
            VitaminASolution,
            MMR,
            DPT_Booster,
            OPV_Booster,
            DT,
            TT,
        }

        enum class Age {
            AtBirth,
            At6Weeks,
            At10Weeks,
            At14Weeks,
            At9Months,
            At15To18Months,
            At16To24Months,
            At5Years,
            At10Years,
            At16Years
        }
    }
}
