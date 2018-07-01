package org.steadytown.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.transaction.Transactional

@SpringBootApplication
class SteadytownApplication

fun main(args: Array<String>) {
    runApplication<SteadytownApplication>(*args)
}

@Service
@Transactional
class MemberService(private val db: JdbcOperations) {

    fun find(name: String) = db.query("SELECT * FROM members WHERE first_name = ?", name) { rs, _ ->
        Member(rs.getString("first_name"), rs.getString("last_name"), rs.getDate("birth_date").toLocalDate())
    }

    fun insert(m: Member) {
        db.execute("INSERT INTO persons(first_name, last_name, birth_date) VALUES (?, ?, ?)") {
            it.setString(0, m.firstName)
            it.setString(1, m.lastName)
            it.setDate(2, java.sql.Date.valueOf(m.birthDate))
        }
    }

}

data class Member (val firstName: String, val lastName: String, val birthDate: LocalDate, var id: Long? = null)