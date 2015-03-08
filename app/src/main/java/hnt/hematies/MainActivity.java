    package hnt.hematies;

    import android.app.AlertDialog;
    import android.content.DialogInterface;
    import android.os.Bundle;
    import android.support.v7.app.ActionBarActivity;
    import android.util.Log;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.SubMenu;
    import android.view.View;
    import android.widget.EditText;
    import android.widget.RadioButton;
    import android.widget.Toast;


    import static android.widget.Toast.*;


    public class MainActivity extends ActionBarActivity {
      private  EditText  text;
        private String leresultat;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
				Log.i("TESTE","Radnou") ;
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
		}


		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
            SubMenu m= menu.addSubMenu(0,2000,0,"Sous-menu");
            //ajout de sous-menu au 'Sous-menu'+ def etat menu
            m.add(0,1000,0,"Menu 1");
            m.add(0,1001,0,"Menu 2");
			getMenuInflater().inflate(R.menu.menu_main, menu);

			return true;
		}

        @Override
        public View findViewById(int id) {
            return super.findViewById(id);
        }

        @Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// Handle action bar item clicks here. The action bar will
			// automatically handle clicks on the Home/Up button, so long
			// as you specify a parent activity in AndroidManifest.xml.
			int id = item.getItemId();

			//noinspection SimplifiableIfStatement
			if (id == R.id.action_settings) {
				return true;
			}

			return super.onOptionsItemSelected(item);
		}

        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnCalcul:
                   AlertDialog.Builder Msgbox= new AlertDialog.Builder(this);
                    text =(EditText)findViewById(R.id.inp_hematie);
                    RadioButton homme=(RadioButton)findViewById(R.id.rdHomme);
                    RadioButton femme=(RadioButton)findViewById(R.id.rdFemme);
                    if(text.getText().length()==0){
                        Toast.makeText(this,"Veuillez entrer un nombre valide",Toast.LENGTH_LONG).show();
                        return;
                    }
                    float inputValue =Float.parseFloat(text.getText().toString());
                    //teste sur radio button
                    if(homme.isChecked() || femme.isChecked() ){
                        if(homme.isChecked()){
                            leresultat=(hematies.Resultat_hematies(inputValue,4.6,6.2));

                            // text.setText(hematies.Resultat_hematies(inputValue,4.6,6.2));
                        }if(femme.isChecked()){
                            leresultat=(hematies.Resultat_hematies(inputValue,4.2,5.4));

                            //    text.setText(hematies.Resultat_hematies(inputValue,4.2,5.4));
                        }
                    }else{
                        leresultat="Veuillez sélectionner le genre";
                    }
                        //définition du Message box.
                    Msgbox.setMessage(leresultat)
                            .setPositiveButton("Continuer",new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .create();
                    Msgbox.show();
                    break;
            }
        }
    }
