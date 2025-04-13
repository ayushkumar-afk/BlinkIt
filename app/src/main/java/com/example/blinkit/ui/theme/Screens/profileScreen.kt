import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blinkit.R


val BlinkitLightYellow = Color(0xFFFFFBE6)
val BlinkitLightGreen = Color(0xFFE8F5E9)
val BlinkitGray = Color(0xFFEEEEEE)
val BlinkitDarkGray = Color(0xFF757575)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlinkitProfileScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Profile",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),

            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()

                .padding(paddingValues)
                .background(Color.White)
        )
        {
            Divider(
                color = Color.Gray,
                thickness = 0.2.dp,
                modifier = Modifier.padding(top = 8.dp).shadow(4.dp, shape = RoundedCornerShape(4.dp)) // Adjust padding if needed
            )
            // Profile Info
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp)
            ) {
                Text(
                    text = "Your account",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 4.dp)
                )

                Text(
                    text = "9044197730",
                    fontSize = 16.sp,
                    color = BlinkitDarkGray,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            Column(modifier = Modifier.verticalScroll(scrollState)) {
                // Quick Actions
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = BlinkitLightYellow),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        QuickActionItem("Zomato Money",R.drawable.payment)
                        QuickActionItem("Support",R.drawable.message)
                        QuickActionItem("Payments",R.drawable.payment)
                    }
                }

                // Appearance Section
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = CardDefaults.cardColors(containerColor = BlinkitLightGreen),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box( modifier = Modifier.background(color = Color.White, shape = CircleShape).size(30.dp),
                                contentAlignment = Alignment.Center
                                ) {
                                Icon(
                                    painter = painterResource(R.drawable.sun),
                                    contentDescription = "Appearance",
                                    tint = BlinkitDarkGray,
                                    modifier = Modifier.size(18.dp)
                                )
                            }

                            Text(
                                text = "Appearance",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.padding(start = 12.dp)
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "LIGHT",
                                fontSize = 14.sp,
                                color = BlinkitDarkGray
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = "Select",
                                tint = BlinkitDarkGray,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }

                // Your Information
                SectionHeader(title = "YOUR INFORMATION")
                SettingsItem("Your orders",R.drawable.order )
                SettingsItem("Bookmarked recipes",R.drawable.thumbs)
                SettingsItem("Address book",R.drawable.addressbook)
                SettingsItem("GST details",R.drawable.reciept)
                SettingsItem("E-Gift Cards",R.drawable.giftcard)

                // Payments and Coupons
                SectionHeader(title = "PAYMENTS AND COUPONS")
                SettingsItem("Wallet",R.drawable.payment)
                SettingsItem("Zomato Money",R.drawable.payment)
                SettingsItem("Payment Settings",R.drawable.payment)
                SettingsItem("Collected coupons",R.drawable.coupons)


                // Here is the Other Information Cards
                SectionHeader(title = "OTHER INFORMATION")
                SettingsItem("Share the app",R.drawable.share)
                SettingsItem("About us",R.drawable.info)
                SettingsItem("Get Feeding India receipt",R.drawable.eye)
                SettingsItem("Account privacy",R.drawable.lock)
                SettingsItem("Notification preferences",R.drawable.notification)
                SettingsItem("Log out",R.drawable.logout)

                Spacer(modifier = Modifier.height(60.dp))
            }


        }
    }
}

@Composable
fun QuickActionItem(text: String,image: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Icon(
                painter = painterResource(image),
                contentDescription = text,
                tint = Color.DarkGray,
                modifier = Modifier.size(20.dp)
            )


        Text(
            text = text,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        fontSize = 12.sp,
        color = BlinkitDarkGray,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 4.dp)
    )
}

@Composable
fun SettingsItem(title: String,image : Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(BlinkitGray),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(image),
                contentDescription = title,
                tint = Color.Gray,
                modifier = Modifier.size(16.dp)
            )
        }

        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
        )

        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = BlinkitDarkGray,
            modifier = Modifier.size(20.dp)
        )
    }


}
