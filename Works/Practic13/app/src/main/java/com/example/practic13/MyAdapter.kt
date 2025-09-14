import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.practic13.Data.Student
import com.example.practic13.MainActivity
import com.example.practic13.R

class MyAdapter(
    context: Context, val activity: Activity,
    private val students: List<Student>
) : ArrayAdapter<Student>(context, 0, students) {

    private class ViewHolder {
        lateinit var tvGroup: TextView
        lateinit var tvFullName: TextView
        lateinit var tvDisciplines: TextView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.student_list, parent, false)

            holder = ViewHolder()
            holder.tvGroup = view.findViewById(R.id.tvGroup)
            holder.tvFullName = view.findViewById(R.id.tvFullName)
            holder.tvDisciplines = view.findViewById(R.id.tvDisciplines)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }
        val student = getItem(position)

        student?.let {
            holder.tvGroup.text = "Группа: ${it.group.name}"
            holder.tvFullName.text = it.fullName
            holder.tvDisciplines.text = "Дисциплина: ${it.discipline.name}"
            holder.tvGroup.setOnClickListener { _ ->
                createAlert("Куратор группы: ${it.group.teacher}")
            }
            holder.tvDisciplines.setOnClickListener { _ ->
                createAlert("Преподаватель: ${student.discipline.teacher}")
            }
            holder.tvFullName.setOnClickListener { _ ->
                AlertDialog.Builder(context)
                    .setTitle("Виход")
                    .setMessage("Хочешь выйти?")
                    .setPositiveButton("Дя"){ dialogInterface, i -> activity.finishAffinity()}
                    .setNegativeButton("Нит"){dialogInterface, i -> }.show()
            }
        }

        return view
    }
    fun createAlert(message: String) {
        AlertDialog.Builder(context)
            .setTitle("Info")
            .setMessage(message)
            .setNeutralButton("Ok"){ dialogInterface, i -> }.show()

    }
}