package mavenapp;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

public interface StudRepo extends JpaRepository<Student,Long> {

	public Student findBystudid(Long studid);

	public List<Student> findBystudname(String studname);

	public List<Student> findBystudsem(String studsem);

	public List<Student> findBystudbranch(String studbranch);

	public void deleteById(Long id);

}
