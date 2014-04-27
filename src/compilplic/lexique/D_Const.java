package compilplic.lexique;

import java.util.ArrayList;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class D_Const extends Declaration
{
	
	public ArrayList<Instruction> instruction;

    public D_Const(String idf, int line, ArrayList<Instruction> l) {
        super(idf, line);
        instruction = l ;
    }

    @Override
    public String toString() {
        return "D_Const{" + "instruction=" + instruction + '}';
    }
	
        

}

