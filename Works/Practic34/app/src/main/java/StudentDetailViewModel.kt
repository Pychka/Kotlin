import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class StudentDetailViewModel {
    private val _studentInfo = MutableLiveData<Student>()

    val studentInfo: LiveData<Student>
        get() = _studentInfo

    fun loadStudentInfo(studentId: String) {
        val student = Student(
            name =  "Ideal Name",
            rollNumber = "20",
            dateOfBirth = "2000-01-01",
            address ="Ideal Address",
            gender = "Male"
        )
        _studentInfo.value = student
    }

}