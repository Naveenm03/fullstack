import * as React from "react";
import { styled, createTheme, ThemeProvider } from "@mui/material/styles";
import CssBaseline from "@mui/material/CssBaseline";
import Box from "@mui/material/Box";
import MuiDrawer from "@mui/material/Drawer";
import MuiAppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import List from "@mui/material/List";
import Typography from "@mui/material/Typography";
import Divider from "@mui/material/Divider";
import IconButton from "@mui/material/IconButton";
import Badge from "@mui/material/Badge";
import MenuIcon from "@mui/icons-material/Menu";
import ChevronLeftIcon from "@mui/icons-material/ChevronLeft";
import NotificationsIcon from "@mui/icons-material/Notifications";
import Container from "@mui/material/Container";
import Paper from "@mui/material/Paper";
import Avatar from "@mui/material/Avatar";
import { mainListItems } from "../../Components/Admin/ListItems";

const drawerWidth = 240;

const AppBar = styled(MuiAppBar, {
  shouldForwardProp: (prop) => prop !== "open",
})(({ theme, open }) => ({
  zIndex: theme.zIndex.drawer + 1,
  transition: theme.transitions.create(["width", "margin"], {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.leavingScreen,
  }),
  ...(open && {
    marginLeft: drawerWidth,
    width: `calc(100% - ${drawerWidth}px)`,
    transition: theme.transitions.create(["width", "margin"], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  }),
}));

const Drawer = styled(MuiDrawer, {
  shouldForwardProp: (prop) => prop !== "open",
})(({ theme, open }) => ({
  "& .MuiDrawer-paper": {
    position: "relative",
    whiteSpace: "nowrap",
    width: drawerWidth,
    transition: theme.transitions.create("width", {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
    boxSizing: "border-box",
    ...(!open && {
      overflowX: "hidden",
      transition: theme.transitions.create("width", {
        easing: theme.transitions.easing.sharp,
        duration: theme.transitions.duration.leavingScreen,
      }),
      width: theme.spacing(7),
      [theme.breakpoints.up("sm")]: {
        width: theme.spacing(9),
      },
    }),
  },
}));

// TODO remove, this demo shouldn't need to reset the theme.
const defaultTheme = createTheme();

export default function AdminProfile() {
  const [open, setOpen] = React.useState(true);
  const toggleDrawer = () => {
    setOpen(!open);
  };
  // Assuming user details are available, replace these with actual user details.
  const user = {
    name: "John Doe",
    email: "john.doe@example.com",
    phone: "+1234567890",
  };

  // Sample data for institutions, students, and courses counts
  const institutionCount = 10;
  const studentCount = 500;
  const courseCount = 30;

  return (
    <ThemeProvider theme={defaultTheme}>
      <Box sx={{ display: "flex" }}>
        <CssBaseline />
        <AppBar position="absolute" open={open}>
          <Toolbar
            sx={{
              pr: "24px", // keep right padding when drawer closed
            }}
          >
            <IconButton
              edge="start"
              color="inherit"
              aria-label="open drawer"
              onClick={toggleDrawer}
              sx={{
                marginRight: "36px",
                ...(open && { display: "none" }),
              }}
            >
              <MenuIcon />
            </IconButton>
            <Typography
              component="h1"
              variant="h6"
              color="inherit"
              noWrap
              sx={{ flexGrow: 1 }}
            >
              Admin Dashboard
            </Typography>
            <IconButton color="inherit">
              <Badge badgeContent={4} color="secondary">
                <NotificationsIcon />
              </Badge>
            </IconButton>
          </Toolbar>
        </AppBar>
        <Drawer variant="permanent" open={open}>
          <Toolbar
            sx={{
              display: "flex",
              alignItems: "center",
              justifyContent: "flex-end",
              px: [1],
            }}
          >
            <IconButton onClick={toggleDrawer}>
              <ChevronLeftIcon />
            </IconButton>
          </Toolbar>
          <Divider />
          <List component="nav">{mainListItems}</List>
        </Drawer>
        <Box
          component="main"
          sx={{
            backgroundColor: (theme) =>
              theme.palette.mode === "light"
                ? theme.palette.grey[100]
                : theme.palette.grey[900],
            flexGrow: 1,
            height: "100vh",
            overflow: "auto",
          }}
        >
          <br />
          <br />
          <br />

          <Container component="main" maxWidth="xs">
            <Paper
              elevation={3}
              style={{
                padding: 20,
                display: "flex",
                flexDirection: "column",
                alignItems: "center",
              }}
            >
              <Avatar style={{ width: 100, height: 100, marginBottom: 10 }}>
                P
              </Avatar>
              <Typography
                component="h1"
                variant="h5"
                style={{ marginBottom: 10 }}
              >
                Admin Profile
              </Typography>
              
              <Typography component={"h1"} variant="h6">
                <strong>Name: </strong>
                {user.name}
              </Typography>
              <br />
              <Typography component={"h1"} variant="h6">
                <strong>Email: </strong>
                {user.email}
              </Typography>
              <br />
              <Typography component={"h1"} variant="h6">
                <strong>Phone: </strong>
                {user.phone}
              </Typography>
              <br />
            </Paper>

            {/* New Cards for counts */}
            <Box
              component="div"
              sx={{
                display: "flex",
                justifyContent: "space-around",
                marginTop: 20,
              }}
            >
              {/* Institutions Count Card */}
              <Paper
                elevation={3}
                style={{
                  padding: 20,
                  display: "flex",
                  flexDirection: "column",
                  alignItems: "center",
                  flex: 1,
                }}
              >
                <Typography component={"h1"} variant="h6">
                  <strong>Institutions: </strong>
                  {institutionCount}
                </Typography>
              </Paper>

              {/* Students Count Card */}
              <Paper
                elevation={3}
                style={{
                  padding: 20,
                  display: "flex",
                  flexDirection: "column",
                  alignItems: "center",
                  flex: 1,
                }}
              >
                <Typography component={"h1"} variant="h6">
                  <strong>Students: </strong>
                  {studentCount}
                </Typography>
              </Paper>

              {/* Courses Count Card */}
              <Paper
                elevation={3}
                style={{
                  padding: 20,
                  display: "flex",
                  flexDirection: "column",
                  alignItems: "center",
                  flex: 1,
                }}
              >
                <Typography component={"h1"} variant="h6">
                  <strong>Courses: </strong>
                  {courseCount}
                </Typography>
              </Paper>
            </Box>
            <br/>
            <br/>
            <br/>
            <br/>
          </Container>
        </Box>
      </Box>
    </ThemeProvider>
  );
}
