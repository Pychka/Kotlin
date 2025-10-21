import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class StudentDetailViewModelTest {

    private lateinit var viewModel: StudentDetailViewModel

    @Before
    fun setUp() {
        viewModel = StudentDetailViewModel()
    }

    @Test
    fun testViewModelInstantiation() {
        assertNotNull(viewModel)
    }

    @Test
    fun testLoadStudent() {
        val studentDetailViewModel = StudentDetailViewModel()
        val expectedName = "Ideal Name"
        val expectedRollNo = "20"
        val expectedDob = "2000-01-01"
        val expectedAddress = "Ideal Address"
        val expectedGender = "Male"

        val rollNo = "20"

        studentDetailViewModel.loadStudentInfo(rollNo)

        assertEquals(expectedName, studentDetailViewModel.studentInfo.value?.name ?: "")
        assertEquals(expectedRollNo, studentDetailViewModel.studentInfo.value?.rollNumber)
        assertEquals(expectedDob, studentDetailViewModel.studentInfo.value?.dateOfBirth ?: "")
        assertEquals(expectedAddress, studentDetailViewModel.studentInfo.value?.address ?: "")
        assertEquals(expectedGender, studentDetailViewModel.studentInfo.value?.gender ?: "")
    }
}
