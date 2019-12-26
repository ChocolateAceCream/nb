import { NgModule } from '@angular/core';
import { MaterialFileInputModule } from 'ngx-material-file-input';
import {
    MatButtonModule,
    MatTabsModule,
    MatNativeDateModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatSelectModule,
    MatFormFieldModule,
    MatCardModule,
    MatToolbarModule,
    MatListModule,
    MatDialogModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    MatSnackBarModule,
    MatStepperModule,
    MatInputModule
} from '@angular/material';
@NgModule({
    imports: [
        MatButtonModule,
        MatSelectModule,
        MatDatepickerModule,
        MatTabsModule,
        MatNativeDateModule,
        MatIconModule,
        MatFormFieldModule,
        MatInputModule,
        MatDialogModule,
        MatToolbarModule,
        MatPaginatorModule,
        MatTableModule,
        MatSortModule,
        MatCardModule,
        MatSnackBarModule,
        MatProgressSpinnerModule,
        MatListModule,
        MatStepperModule,
        MatCheckboxModule
    ],
    exports: [
        MatButtonModule,
        MatTabsModule,
        MatDialogModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatCheckboxModule,
        MatIconModule,
        MatFormFieldModule,
        MatPaginatorModule,
        MatToolbarModule,
        MatTableModule,
        MatSortModule,
        MatListModule,
        MatCardModule,
        MatSnackBarModule,
        MatProgressSpinnerModule,
        MatSelectModule,
        MatStepperModule,
        MaterialFileInputModule,
        MatInputModule
    ]
})
export class MaterialModule {}