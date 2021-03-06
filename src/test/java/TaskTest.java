import org.junit.*;
import static org.junit.Assert.*;

public class TaskTest {

  @Test // nameOfFunction_testCase_expectedResult()
  public void task_instantiatesCorrectly_true() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(true, myTask instanceof Task);
  }

  @Test
  public void task_instantiatesWithDescription_String() {
    Task myTask = new Task("Mow the lawn");
    assertEquals("Mow the lawn", myTask.getDescription());
  }

}
